package com.jisoh.keybinding;

import java.util.List;
import java.util.ArrayList;

public class Result {

	// getters and setters for parsed return
	
		private long id;
		
		private String prediction;
		
	    private String probability;
	    
	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }
	    
	    public String getPredict() {
	        return prediction;
	    }
	
	    public void setPredict(String prediction) {
	        this.prediction = prediction;
	    }
	
	    public String getProbab() {
	        return probability;
	    }
	
	    public void setProbab(String probability) {
	        this.probability = probability;
	    }
	
	    public List<SimilarData> similar_data;
	    
	    public List<SimilarData> getSimilarData() {
	        return similar_data;
	    }
	
			public class SimilarData {
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
			    	return "SimilarData [id="+ id + ", s_Cas_OffCode=" + s_Cas_OffCode + ", s_Cas_Year=" + s_Cas_Year + ", s_Cas_ChildNo=" + s_Cas_ChildNo + ", s_Cas_SeqNo=" + s_Cas_SeqNo + "]";
			    }
			}
	@Override
	public String toString() {
		return "Result [prediction="+ prediction + ", probability=" + probability + similar_data + "]";
	}
}