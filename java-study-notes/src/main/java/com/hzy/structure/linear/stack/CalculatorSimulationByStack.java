package com.hzy.structure.linear.stack;

/**
 * 使用栈模拟计算器功能
 * 解决思路
 */
public class CalculatorSimulationByStack {
    public static void main(String[] args) {
        String expression = "117+13*2-4";
        // 创建两个栈分别存储数值和操作符
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operatorStack = new CalculatorStack(10);
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int index = 0;  // 遍历表达式指针
        int res = 0;  // 结果
        char ch = ' ';  // 每次扫面到的字串
        while (index <= expression.length() - 1) {
            // 每次得到一个字符
            ch = expression.substring(index++, index).charAt(0);
            // 判断是否为运算符
            if (CalculatorStack.isOperator(ch)) {
                // 如果操作符栈非空，先比较操作符优先级
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else {
                    // 如果新符号优先级小于符号栈顶优先级，取出栈顶符号和最后两个数栈数计算后，结果入数栈，然后存入新符号
                    if (CalculatorStack.getPriority(ch) > CalculatorStack.getPriority(operatorStack.peek())) {
                        operatorStack.push(ch);
                    } else {
                        operator = operatorStack.pop();
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        res = CalculatorStack.calculate(num1, num2, operator);
                        numStack.push(res);
                        operatorStack.push(ch);
                    }
                }
            } else {
                // 数字且是最后一位直接入数栈
                if (index == expression.length()) {
                    numStack.push(ch - '0');
                } else {
                    // 查看后面字符是否为数字
                    StringBuilder numString = new StringBuilder();
                    numString.append(ch);
                    int add = 0;
                    char charTemp;
                    while (!CalculatorStack.isOperator((charTemp = expression.substring(index + add, index + add + 1).charAt(0)))) {
                        numString.append(charTemp);
                        add++;
                    }
                    index = index + add;
                    numStack.push(Integer.parseInt(numString.toString()));
                }
            }
        }
        numStack.list();
        operatorStack.list();
        //遍历操作符栈计算并存入数栈，直到操作符栈为空
        while (!operatorStack.isEmpty()) {
            operator = operatorStack.pop();
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = CalculatorStack.calculate(num1, num2, operator);
            numStack.push(res);
        }
        System.out.printf("表达式 %s = %d ", expression, numStack.peek());
    }


}

/**
 * 继承已有的栈结构
 * 增加 判断数字 和 运算符方法
 * 增加判断符号优先级方法
 */
class CalculatorStack extends ArrayStack {

    public CalculatorStack(int maxSize) {
        super(maxSize);
    }

    /**
     * 判断符号优先级方法
     *
     * @param operator 操作符
     * @return 优先级数
     */
    public static int getPriority(int operator) {
        if ('*' == operator || '/' == operator) {
            return 1;
        } else if ('+' == operator || '-' == operator) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否为操作符
     *
     * @param value 传入值
     * @return 是否操作符
     */
    public static boolean isOperator(char value) {
        return getPriority(value) > -1;
    }

    /**
     * 计算方法
     *
     * @param num1     参数一
     * @param num2     参数二
     * @param operator 操作符
     * @return 结果
     */
    public static int calculate(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':  // 注意减法，后出栈的作为减数
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':  // 注意除法，后出栈的作为减数
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}
