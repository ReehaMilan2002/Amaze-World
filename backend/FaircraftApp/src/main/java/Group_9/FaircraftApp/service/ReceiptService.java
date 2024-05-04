package Group_9.FaircraftApp.service;

import Group_9.FaircraftApp.model.Receipt;
import Group_9.FaircraftApp.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Receipt addReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public Receipt editReceipt(Long id, Receipt updatedReceipt) {
        Optional<Receipt> existingReceiptOptional = receiptRepository.findById(id);

        if (existingReceiptOptional.isPresent()) {
            Receipt existingReceipt = existingReceiptOptional.get();
            existingReceipt.setArtisansID(updatedReceipt.getArtisansID());
            existingReceipt.setDate(updatedReceipt.getDate());
            existingReceipt.setMiddlemanID(updatedReceipt.getMiddlemanID());
            existingReceipt.setPayment(updatedReceipt.getPayment());

            return receiptRepository.save(existingReceipt);
        }

        return null; // Handle the case where the receipt with the given id is not found
    }

    public void acceptReceipt(Long id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        if (receipt.isPresent()) {
            receipt.get().setAccepted("Yes");
            receiptRepository.save(receipt.get());
        }
    }

    public void rejectReceipt(Long id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        if (receipt.isPresent()) {
            receipt.get().setAccepted("No");
            receiptRepository.save(receipt.get());
        }
    }

    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }
}
