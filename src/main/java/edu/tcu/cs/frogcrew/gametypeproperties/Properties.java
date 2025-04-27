package edu.tcu.cs.frogcrew.gametypeproperties;

import jakarta.validation.constraints.NotEmpty;

public class Properties {
        @NotEmpty(message = "Pay rate is required") private String payRate;
        @NotEmpty(message = "Report time is required") private String reportTime;

        public Properties(String payRate, String reportTime) {
            this.payRate = payRate;
            this.reportTime = reportTime;
        }

        public String getPayRateProperty() {
            return payRate;
        }

        public void setPayRateProperty(String payRate) {
            this.payRate = payRate;
        }

        public String getReportTimeProperty() {
            return reportTime;
        }

        public void setReportTimeProperty(String reportTime) {
            this.reportTime = reportTime;
        }
    }
