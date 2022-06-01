package customtype;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import objects.BillingDetails;

import java.util.List;

public class CustomDataTableType {
    @DataTableType
    public BillingDetails billingDetailsInput (DataTable inputData) {
        List<String> billingDetails = inputData.row(1);
        return new BillingDetails(
                billingDetails.get(0),
                billingDetails.get(1),
                billingDetails.get(2),
                billingDetails.get(3),
                billingDetails.get(4),
                billingDetails.get(5),
                billingDetails.get(6),
                billingDetails.get(7)
        );
    }
}
