package com.hzy.designpatterns.chainofresponsibility;

public class Approver02 extends Approver {

    public Approver02(String name) {
        super(name);
    }

    @Override
    public void dealRequest(ApprovalRequest approvalRequest) {
        if (approvalRequest.getPrice() > 5000 && approvalRequest.getPrice() <= 10000) {
            System.out.println(this.name + "处理了"+approvalRequest.getId());
        } else {
            this.approver.dealRequest(approvalRequest);
        }
    }
}
