package benjamin.sinzore.Service;

import benjamin.sinzore.Dao.Dao;
import benjamin.sinzore.model.RequestBody.*;
import benjamin.sinzore.model.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try{
            getRes.setStatus(200);
            getRes.setMessage("Hello, here is a list of Customers Pending Approval.");
            getRes.setError("null");
            getRes.setData(dao.BankEmployeeLoginAndReturnCustomerPendingApproval(regModel));
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


    public CustomerTransaction_Deposit CustomerTransaction_Deposit(CustomerTransactionsReq resModel){

        CustomerTransaction_Deposit res = new CustomerTransaction_Deposit();

        //Check if amount is 0 or a negative value
        if(resModel.getAmount() <= 0) {
            res.setMessage("Please check the amount before you proceed.");
        } else {

            try {

                res.setMessage((String) dao.CustomerTransaction_Deposit(resModel).getSingleResult());
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }

        return res;
    }

    public CustomerTransaction_Withdraw CustomerTransaction_Withdraw(CustomerTransactionsReq resModel){

        CustomerTransaction_Withdraw res = new CustomerTransaction_Withdraw();

        if(resModel.getAmount() <= 0) {
            res.setMessage("Please check the amount before you proceed.");
        } else {
            try {
                res.setMessage((String) dao.CustomerTransaction_Withdraw(resModel).getSingleResult());
            } catch (Exception ee){
                ee.printStackTrace();
            }
        }

        return res;
    }

    public CustomerTransaction_TransferFunds CustomerTransaction_TransferFunds(CustomerTransaction_TransferFundsReq resModel){

        CustomerTransaction_TransferFunds res = new CustomerTransaction_TransferFunds();
        try {
            res.setMessage((String) dao.CustomerTransaction_TransferFunds(resModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }

    public CustomerTransaction_GetAvailableBalanceRes CustomerTransaction_GetAvailableBalance(GetAvailableBalance resModel){

        CustomerTransaction_GetAvailableBalanceRes res = new CustomerTransaction_GetAvailableBalanceRes();
        try {
            res.setMessage((String) dao.CustomerTransaction_GetAvailableBalanceRes(resModel).getSingleResult());
        } catch (Exception ee){
            ee.printStackTrace();
        }
        return res;
    }
}
