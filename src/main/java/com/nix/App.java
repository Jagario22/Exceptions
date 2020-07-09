package com.nix;

import com.nix.block.Block;
import com.nix.block.CheckDate;

public class App {
    private static final Block block = new CheckDate();

    public static void main(String[] args) throws Exception {
        Reply.run((CheckDate) block);
    }

}
