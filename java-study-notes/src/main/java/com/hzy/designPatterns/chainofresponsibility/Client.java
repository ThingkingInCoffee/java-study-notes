package com.hzy.designPatterns.chainofresponsibility;

public class Client {

    public static void main(String[] args) {
        ApprovalRequest request = new ApprovalRequest(1,40000,1);

        Approver01 approver01 = new Approver01("李老师");
        Approver02 approver02 = new Approver02("王院长");
        Approver03 approver03 = new Approver03("马副校长");
        Approver04 approver04 = new Approver04("张校长");

        approver01.setApprover(approver02);
        approver02.setApprover(approver03);
        approver03.setApprover(approver04);
        approver04.setApprover(approver01);

        approver01.dealRequest(request);
    }

}
