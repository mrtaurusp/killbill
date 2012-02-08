/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.payment.api;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.google.common.base.Objects;
import com.ning.billing.util.bus.BusEvent;

public class PaymentInfo implements BusEvent {
    private final String paymentId;
    private final BigDecimal amount;
    private final BigDecimal refundAmount;
    private final String paymentNumber;
    private final String bankIdentificationNumber;
    private final String status;
    private final String type;
    private final String referenceId;
    private final String paymentMethodId;
    private final String paymentMethod;
    private final String cardType;
    private final String cardCoutry;
    private final DateTime effectiveDate;
    private final DateTime createdDate;
    private final DateTime updatedDate;

    @JsonCreator
    public PaymentInfo(@JsonProperty("paymentId") String paymentId,
                       @JsonProperty("amount") BigDecimal amount,
                       @JsonProperty("refundAmount") BigDecimal refundAmount,
                       @JsonProperty("bankIdentificationNumber") String bankIdentificationNumber,
                       @JsonProperty("paymentNumber") String paymentNumber,
                       @JsonProperty("status") String status,
                       @JsonProperty("type") String type,
                       @JsonProperty("referenceId") String referenceId,
                       @JsonProperty("paymentMethodId") String paymentMethodId,
                       @JsonProperty("paymentMethod") String paymentMethod,
                       @JsonProperty("cardType") String cardType,
                       @JsonProperty("cardCountry") String cardCountry,
                       @JsonProperty("effectiveDate") DateTime effectiveDate,
                       @JsonProperty("createdDate") DateTime createdDate,
                       @JsonProperty("updatedDate") DateTime updatedDate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.refundAmount = refundAmount;
        this.bankIdentificationNumber = bankIdentificationNumber;
        this.paymentNumber = paymentNumber;
        this.status = status;
        this.type = type;
        this.referenceId = referenceId;
        this.paymentMethodId = paymentMethodId;
        this.paymentMethod = paymentMethod;
        this.cardType = cardType;
        this.cardCoutry = cardCountry;
        this.effectiveDate = effectiveDate;
        this.createdDate = createdDate == null ? new DateTime(DateTimeZone.UTC) : createdDate;
        this.updatedDate = updatedDate == null ? new DateTime(DateTimeZone.UTC) : updatedDate;
    }

    public PaymentInfo(PaymentInfo src) {
        this(src.paymentId,
             src.amount,
             src.refundAmount,
             src.bankIdentificationNumber,
             src.paymentNumber,
             src.status,
             src.type,
             src.referenceId,
             src.paymentMethodId,
             src.paymentMethod,
             src.cardType,
             src.cardCoutry,
             src.effectiveDate,
             src.createdDate,
             src.updatedDate);
    }

    public Builder cloner() {
        return new Builder(this);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getBankIdentificationNumber() {
        return bankIdentificationNumber;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public DateTime getEffectiveDate() {
        return effectiveDate;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardCountry() {
        return cardCoutry;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public DateTime getUpdatedDate() {
        return updatedDate;
    }

    public static class Builder {
        private String paymentId;
        private BigDecimal amount;
        private BigDecimal refundAmount;
        private String paymentNumber;
        private String bankIdentificationNumber;
        private String type;
        private String status;
        private String referenceId;
        private String paymentMethodId;
        private String paymentMethod;
        private String cardType;
        private String cardCountry;
        private DateTime effectiveDate;
        private DateTime createdDate;
        private DateTime updatedDate;

        public Builder() {
        }

        public Builder(PaymentInfo src) {
            this.paymentId = src.paymentId;
            this.amount = src.amount;
            this.refundAmount = src.refundAmount;
            this.paymentNumber = src.paymentNumber;
            this.bankIdentificationNumber = src.bankIdentificationNumber;
            this.type = src.type;
            this.status = src.status;
            this.effectiveDate = src.effectiveDate;
            this.referenceId = src.referenceId;
            this.paymentMethodId = src.paymentMethodId;
            this.paymentMethod = src.paymentMethod;
            this.cardType = src.cardType;
            this.cardCountry = src.cardCoutry;
            this.createdDate = src.createdDate;
            this.updatedDate = src.updatedDate;
        }

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setBankIdentificationNumber(String bankIdentificationNumber) {
            this.bankIdentificationNumber = bankIdentificationNumber;
            return this;
        }

        public Builder setCreatedDate(DateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder setEffectiveDate(DateTime effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder setPaymentNumber(String paymentNumber) {
            this.paymentNumber = paymentNumber;
            return this;
        }

        public Builder setReferenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public Builder setRefundAmount(BigDecimal refundAmount) {
            this.refundAmount = refundAmount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setPaymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setCardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        public Builder setCardCountry(String cardCountry) {
            this.cardCountry = cardCountry;
            return this;
        }

        public Builder setUpdatedDate(DateTime updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public PaymentInfo build() {
            return new PaymentInfo(paymentId,
                                   amount,
                                   refundAmount,
                                   bankIdentificationNumber,
                                   paymentNumber,
                                   status,
                                   type,
                                   referenceId,
                                   paymentMethodId,
                                   paymentMethod,
                                   cardType,
                                   cardCountry,
                                   effectiveDate,
                                   createdDate,
                                   updatedDate);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(paymentId,
                                amount,
                                refundAmount,
                                bankIdentificationNumber,
                                paymentNumber,
                                status,
                                type,
                                referenceId,
                                paymentMethodId,
                                paymentMethod,
                                cardType,
                                cardCoutry,
                                effectiveDate,
                                createdDate,
                                updatedDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == obj.getClass()) {
            PaymentInfo other = (PaymentInfo)obj;
            if (obj == other) {
                return true;
            }
            else {
                return Objects.equal(amount, other.amount) &&
                       Objects.equal(bankIdentificationNumber, other.bankIdentificationNumber) &&
                       Objects.equal(paymentId, other.paymentId) &&
                       Objects.equal(paymentNumber, other.paymentNumber) &&
                       Objects.equal(referenceId, other.referenceId) &&
                       Objects.equal(refundAmount, other.refundAmount) &&
                       Objects.equal(status, other.status) &&
                       Objects.equal(type, other.type) &&
                       Objects.equal(paymentMethodId, other.paymentMethodId) &&
                       Objects.equal(paymentMethod, other.paymentMethod) &&
                       Objects.equal(cardType, other.cardType) &&
                       Objects.equal(cardCoutry, other.cardCoutry) &&
                       Objects.equal(effectiveDate, other.effectiveDate) &&
                       Objects.equal(createdDate, other.createdDate) &&
                       Objects.equal(updatedDate, other.updatedDate);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PaymentInfo [paymentId=" + paymentId + ", amount=" + amount + ", refundAmount=" + refundAmount + ", paymentNumber=" + paymentNumber + ", bankIdentificationNumber=" + bankIdentificationNumber + ", status=" + status + ", type=" + type + ", referenceId=" + referenceId + ", paymentMethodId=" + paymentMethodId + ", paymentMethod=" + paymentMethod + ", cardType=" + cardType + ", cardCountry=" + cardCoutry + ", effectiveDate=" + effectiveDate + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
    }

}
