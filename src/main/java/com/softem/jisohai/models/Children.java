package com.softem.jisohai.models;

public class Children {

	// getters and setters
    private long id;

    private String s_Cas_OffCode;

    private String s_Cas_Year;

    private String s_Cas_ChildNo;

    private String s_Cas_SeqNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOffCode() {
        return s_Cas_OffCode;
    }

    public void setOffCode(String offCode) {
        this.s_Cas_OffCode = offCode;
    }

    public String getYearNo() {
        return s_Cas_Year;
    }

    public void setYearNo(String yearNo) {
        this.s_Cas_Year = yearNo;
    }

    public String getChildNo() {
        return s_Cas_ChildNo;
    }

    public void setChildNo(String childNo) {
        this.s_Cas_ChildNo = childNo;
    }

    public String getSeqNo() {
        return s_Cas_SeqNo;
    }

    public void setSeqNo(String seqNo) {
        this.s_Cas_SeqNo = seqNo;
    }
    
    @Override
    public String toString() {
    	return "PrimaryKey [id="+ id + ", s_Cas_OffCode=" + s_Cas_OffCode + ", s_Cas_Year=" + s_Cas_Year + ", s_Cas_ChildNo=" + s_Cas_ChildNo + ", s_Cas_SeqNo=" + s_Cas_SeqNo + "]";
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((offCode == null) ? 0 : offCode.hashCode());
//        result = prime * result + (int) (id ^ (id >>> 32));
//        result = prime * result + ((yearNo == null) ? 0 : yearNo.hashCode());
//        result = prime * result + ((childNo == null) ? 0 : childNo.hashCode());
//        result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        PrimaryKey other = (PrimaryKey) obj;
//        if (offCode == null) {
//            if (other.offCode != null)
//                return false;
//        } else if (!offCode.equals(other.offCode))
//            return false;
//        if (id != other.id)
//            return false;
//        if (yearNo == null) {
//            if (other.yearNo != null)
//                return false;
//        } else if (!yearNo.equals(other.yearNo))
//            return false;
//        if (childNo == null) {
//            if (other.childNo != null)
//                return false;
//        } else if (!childNo.equals(other.childNo))
//            return false;
//        if (seqNo == null) {
//            if (other.seqNo != null)
//                return false;
//        } else if (!seqNo.equals(other.seqNo))
//            return false;
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "PrimaryKey [id=" + id + ", s_Cas_OffCode=" + offCode + ", s_Cas_Year=" + yearNo + ", s_Cas_ChildNo=" + childNo + ", s_Cas_SeqNo=" + seqNo "]";
//    }
}