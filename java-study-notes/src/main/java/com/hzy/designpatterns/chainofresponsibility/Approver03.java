package com.hzy.designpatterns.chainofresponsibility;

public class Approver03 extends Approver {

    public Approver03(String name) {
        super(name);
    }

    @Override
    public void dealRequest(ApprovalRequest approvalRequest) {
        if (approvalRequest.getPrice() > 10000 && approvalRequest.getPrice() <= 30000) {
            System.out.println(this.name + "处理了"+approvalRequest.getId());
        } else {
            this.approver.dealRequest(approvalRequest);
        }
    }
}
