package com.hzy.designPatterns.chainofresponsibility;

public class Approver01 extends Approver {

    public Approver01(String name) {
        super(name);
    }

    @Override
    public void dealRequest(ApprovalRequest approvalRequest) {
        if (approvalRequest.getPrice() <= 5000) {
            System.out.println(this.name + "处理了"+approvalRequest.getId());
        } else {
            this.approver.dealRequest(approvalRequest);
        }
    }
}
