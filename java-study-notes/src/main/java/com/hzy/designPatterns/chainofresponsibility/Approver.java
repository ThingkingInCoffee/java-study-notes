package com.hzy.designPatterns.chainofresponsibility;

/**
 * 审批人抽象类
 */
public abstract class Approver {

    String name;
    //下一级审批人
    Approver approver;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    /**
     * 具体实现交给子类处理
     * @param approvalRequest
     */
    public abstract void dealRequest(ApprovalRequest approvalRequest);
}
