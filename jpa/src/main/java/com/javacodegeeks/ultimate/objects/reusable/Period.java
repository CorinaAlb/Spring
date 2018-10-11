package com.javacodegeeks.ultimate.objects.reusable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class Period {

    private Date StartDate;
    private Date EndDate;

    @Column(name = "START_DATE")
    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    @Column(name = "END_DATE")
    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }
}
