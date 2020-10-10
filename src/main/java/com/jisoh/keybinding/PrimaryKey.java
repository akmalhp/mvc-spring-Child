package com.jisoh.keybinding;

public class PrimaryKey {

    private long id;

    private String offCode;

    private String yearNo;

    private String childNo;

    private String seqNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOffCode() {
        return offCode;
    }

    public void setOffCode(String offCode) {
        this.offCode = offCode;
    }

    public String getYearNo() {
        return yearNo;
    }

    public void setYearNo(String yearNo) {
        this.yearNo = yearNo;
    }

    public String getChildNo() {
        return childNo;
    }

    public void setChildNo(String childNo) {
        this.childNo = childNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((offCode == null) ? 0 : offCode.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((yearNo == null) ? 0 : yearNo.hashCode());
        result = prime * result + ((childNo == null) ? 0 : childNo.hashCode());
        result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrimaryKey other = (PrimaryKey) obj;
        if (offCode == null) {
            if (other.offCode != null)
                return false;
        } else if (!offCode.equals(other.offCode))
            return false;
        if (id != other.id)
            return false;
        if (yearNo == null) {
            if (other.yearNo != null)
                return false;
        } else if (!yearNo.equals(other.yearNo))
            return false;
        if (childNo == null) {
            if (other.childNo != null)
                return false;
        } else if (!childNo.equals(other.childNo))
            return false;
        if (seqNo == null) {
            if (other.seqNo != null)
                return false;
        } else if (!seqNo.equals(other.seqNo))
            return false;
        return true;
    }

//    @Override
//    public String toString() {
//        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
//    }
}