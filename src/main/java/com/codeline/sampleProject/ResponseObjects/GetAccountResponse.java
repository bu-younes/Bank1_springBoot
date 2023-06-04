package com.codeline.sampleProject.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountResponse {

    String bankName;

    Integer accountNumber;

    String bankBranch;

    public GetAccountResponse(String success, String bankName, String accountNumber) {
    }
}
