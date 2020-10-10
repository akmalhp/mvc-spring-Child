package com.jisoh.keybinding;

import com.jisoh.keybinding.PrimaryKey;
import java.util.List;

public interface BookService {

    List<PrimaryKey> findAll();

    void saveAll(List<PrimaryKey> books);
}