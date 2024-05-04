package Group_9.FaircraftApp.controller;

import Group_9.FaircraftApp.dto.ReceiptDTO;
import org.springframework.web.bind.annotation.*;
import Group_9.FaircraftApp.model.Receipt;
import Group_9.FaircraftApp.service.ReceiptService; // Import the correct service class

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @PostMapping("/addReceipts")
    public Receipt addReceipt(@RequestBody ReceiptDTO receiptDTO) {
        System.out.println("Incoming post request: " + receiptDTO);
        Receipt receipt = new Receipt();
        receipt.setArtisansID(receiptDTO.getArtisansID());
        receipt.setPayment(receiptDTO.getPayment());
        receipt.setDate(receiptDTO.getDate());
        receipt.setMiddlemanID(receiptDTO.getMiddlemanID());
        return receiptService.addReceipt(receipt);
    }

    @PutMapping("/editReceipts/{id}")
    public Receipt editReceipt(@PathVariable Long id, @RequestBody Receipt receipt) {
        return receiptService.editReceipt(id, receipt);
    }

    @GetMapping("/accept/{id}")
    public List<Receipt> acceptReceipt(@PathVariable Long id) {
        receiptService.acceptReceipt(id);
        return receiptService.getAllReceipts();
    }

    @GetMapping("/reject/{id}")
    public List<Receipt> rejectReceipt(@PathVariable Long id) {
        receiptService.rejectReceipt(id);
        return receiptService.getAllReceipts();
    }

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        receiptService.deleteReceipt(id);
    }
}
