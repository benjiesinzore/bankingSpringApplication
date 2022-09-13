package benjamin.sinzore.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import benjamin.sinzore.model.RequestBody.*;
import benjamin.sinzore.model.response.GetAvailableBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Dao {
	
	@Autowired
	private final EntityManager em;
	public Dao(EntityManager em) {
		this.em = em;
	}


	public Query CustomerRegistration(CustomerRegistrationModel regModel){
		return  em.createNamedStoredProcedureQuery("sp_CustomerRegistrationDetails")
				.setParameter("userIDIN", regModel.getUserID())
				.setParameter("userNameIN", regModel.getUserName().trim())
				.setParameter("userPasswordIN", regModel.getUserPassword().trim())
				.setParameter("userEmailAddressIN", regModel.getUserEmailAddress().trim());
	}

	public Query CustomerLogin(CustomerRegistrationModel loginModel){
		return  em.createNamedStoredProcedureQuery("sp_CustomerLogin")
				.setParameter("accountNumberIN", loginModel.getAccountNumber())
				.setParameter("userPasswordIN", loginModel.getUserPassword());
	}

	public Query BankEmployeeRegistration(BankEmployeeRegistrationModel regModel){
		return  em.createNamedStoredProcedureQuery("sp_BankEmployeeRegistrationDetails")
				.setParameter("employeeIDIN", regModel.getEmployeeID())
				.setParameter("employeePasswordIN", regModel.getEmployeePassword())
				.setParameter("employeeNameIN", regModel.getEmployeeName())
				.setParameter("employeeCapacityIN", regModel.getEmployeeCapacity());
	}

	public List BankEmployeeLoginAndReturnCustomerPendingApproval(BankEmployeeRegistrationModel loginModel){
		return em.createNamedStoredProcedureQuery("sp_BankEmployeeLogin")
				.setParameter("employeeIDIN", loginModel.getEmployeeID())
				.setParameter("employeePasswordIN", loginModel.getEmployeePassword()).getResultList();
	}

	public Query CustomerApproval(CustomerRegistrationModel regModel){
		return  em.createNamedStoredProcedureQuery("sp_ApproveCustomer")
				.setParameter("accountNumberIN", regModel.getAccountNumber());
	}


	public Query CustomerTransaction_Deposit(CustomerTransactionsReq regModel){
		return  em.createNamedStoredProcedureQuery("sp_CustomerTransactionDetails_Deposit")
				.setParameter("accountNumberIN", regModel.getAccountNumber())
				.setParameter("amountIN", regModel.getAmount());
	}

	public Query CustomerTransaction_Withdraw(CustomerTransactionsReq regModel){
		return  em.createNamedStoredProcedureQuery("sp_CustomerTransactionDetails_Withdraw")
				.setParameter("accountNumberIN", regModel.getAccountNumber())
				.setParameter("amountIN", regModel.getAmount());
	}

	public Query CustomerTransaction_TransferFunds(CustomerTransaction_TransferFundsReq regModel){
		return  em.createNamedStoredProcedureQuery("sp_CustomerTransaction_TransferFunds")
				.setParameter("accountNumberIN", regModel.getAccountNumber())
				.setParameter("accountNumberToSendToIN", regModel.getAccountNumberToSendTo())
				.setParameter("amountIN", regModel.getAmount());
	}

	public Query CustomerTransaction_GetAvailableBalanceRes(GetAvailableBalance regModel){
		return  em.createNamedStoredProcedureQuery("sp_GetAvailableBalance")
				.setParameter("accountNumberIN", regModel.getAccountNumber());
	}


}