package Group_9.FaircraftApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long artisansID;
    private LocalDate date;
    private Long middlemanID;
    private String payment;
    private String accepted;

    public Receipt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtisansID() {
        return artisansID;
    }

    public void setArtisansID(Long artisansID) {
        this.artisansID = artisansID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getMiddlemanID() {
        return middlemanID;
    }

    public void setMiddlemanID(Long middlemanID) {
        this.middlemanID = middlemanID;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", recipientId=" + artisansID +
                ", date=" + date +
                ", submittedById=" + middlemanID +
                ", transactionType='" + payment + '\'' +
                ", accepted='" + accepted + '\'' +
                '}';
    }
}
