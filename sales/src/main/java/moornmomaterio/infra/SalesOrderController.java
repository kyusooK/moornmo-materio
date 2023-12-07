package moornmomaterio.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import moornmomaterio.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/salesOrders")
@Transactional
public class SalesOrderController {

    @Autowired
    SalesOrderRepository salesOrderRepository;

    @RequestMapping(
        value = "salesOrders/{id}/product",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public SalesOrder product(
        @PathVariable(value = "id") Long id,
        @RequestBody ProductCommand productCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /salesOrder/product  called #####");
        Optional<SalesOrder> optionalSalesOrder = salesOrderRepository.findById(
            id
        );

        optionalSalesOrder.orElseThrow(() -> new Exception("No Entity Found"));
        SalesOrder salesOrder = optionalSalesOrder.get();
        salesOrder.product(productCommand);

        salesOrderRepository.save(salesOrder);
        return salesOrder;
    }
}
//>>> Clean Arch / Inbound Adaptor