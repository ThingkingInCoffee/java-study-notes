package com.hzy.designpatterns.chainofresponsibility;

public class Approver04 extends Approver {

    public Approver04(String name) {
        super(name);
    }

    @Override
    public void dealRequest(ApprovalRequest approvalRequest) {
        if (approvalRequest.getPrice() > 30000 && approvalRequest.getPrice() <= 900000) {
            System.out.println(this.name + "处理了"+approvalRequest.getId());
        } else {
            this.approver.dealRequest(approvalRequest);
        }
    }
}
