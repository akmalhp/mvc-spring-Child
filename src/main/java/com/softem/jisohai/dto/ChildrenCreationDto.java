package com.softem.jisohai.dto;

import java.util.ArrayList;
import java.util.List;

import com.softem.jisohai.models.Children;

public class ChildrenCreationDto {

	// create List "children" for Child Key
    private List<Children> children;
    
    // choose version
    private int version; 

    public ChildrenCreationDto() {
        this.children = new ArrayList<>();
    }

    public ChildrenCreationDto(List<Children> children) {
        this.children = children;
    }
    
    // getters and setters
    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
    
    public int getVersion() {  
        return version;  
    }  
    public void setVersion(int version) {  
        this.version = version;  
    }    
    
    
    // method to add variable
    public void addBook(Children children) {
        this.children.add(children);
    }
}