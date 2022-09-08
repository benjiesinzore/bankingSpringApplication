package benjamin.sinzore.Service;

import benjamin.sinzore.Dao.Dao;
import benjamin.sinzore.model.RequestBody.*;
import benjamin.sinzore.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class Services {

    @Autowired
    private final Dao dao;
    public Services(Dao dao) {
        this.dao = dao;
    }


    public CustomerRegistrationResponse CustomerRegistration(CustomerRegistrationModel regModel){

        CustomerRegistrationResponse res = new CustomerRegistrationResponse();
        try{
            res.setMessage((String) dao.CustomerRegistration(regModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }


    public CustomerLoginResponse CustomerLogin(CustomerRegistrationModel loginModel){

        CustomerLoginResponse res = new CustomerLoginResponse();
        try{
            res.setStatus(200);
            res.setError("null.");
            res.setMessage((String) dao.CustomerLogin(loginModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;

    }


    public BankEmployeeRegistrationResponse BankEmployeeRegistration(BankEmployeeRegistrationModel regModel){

        BankEmployeeRegistrationResponse res = new BankEmployeeRegistrationResponse();
        try{
            res.setMessage((String) dao.BankEmployeeRegistration(regModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }


    public BankEmployeeLoginRes BankEmployeeLoginAndReturnCustomerPendingApproval(BankEmployeeRegistrationModel regModel){

        BankEmployeeLoginRes getRes = new BankEmployeeLoginRes();
        List list;
        try{
            getRes.setStatus(200);
            getRes.setMessage("Here is a list of Customers Pending Approval.");
            getRes.setError("null");

            list = dao.BankEmployeeLoginAndReturnCustomerPendingApproval(regModel);
            getRes.setData(list);
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return getRes;
    }


    public CustomerApprovalModel CustomerApproval(CustomerRegistrationModel resModel){

        CustomerApprovalModel res = new CustomerApprovalModel();
        try {
            res.setMessage((String) dao.CustomerApproval(resModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }


    public CustomerTransaction_Deposit CustomerTransaction_Deposit(CustomerTransaction_DepositReq resModel){

        CustomerTransaction_Deposit res = new CustomerTransaction_Deposit();
        String now = new Date().toString();

        //Check if amount is 0 or a negative value
        if(resModel.getAmount() <= 0) {
            res.setMessage("Please check the amount before you proceed.");
        } else {

            try {
                resModel.setCreatedOn(now);
                res.setMessage((String) dao.CustomerTransaction_Deposit(resModel).getSingleResult());
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }

        return res;
    }

    public CustomerTransaction_Withdraw CustomerTransaction_Withdraw(CustomerTransaction_WithdrawReq resModel){

        CustomerTransaction_Withdraw res = new CustomerTransaction_Withdraw();
        String now = new Date().toString();
        try {
            resModel.setCreatedOn(now);
            res.setMessage((String) dao.CustomerTransaction_Withdraw(resModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }

    public CustomerTransaction_TransferFunds CustomerTransaction_TransferFunds(CustomerTransaction_TransferFundsReq resModel){

        CustomerTransaction_TransferFunds res = new CustomerTransaction_TransferFunds();
        String now = new Date().toString();
        try {
            resModel.setCreatedOn(now);
            res.setMessage((String) dao.CustomerTransaction_TransferFunds(resModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }
}
