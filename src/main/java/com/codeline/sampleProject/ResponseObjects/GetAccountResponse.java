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


    public GetAccountResponse(String bankName, String accountNumber, String bankBranch, String swiftCode) {
    }
}
