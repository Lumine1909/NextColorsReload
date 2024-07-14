package de.nextround.nextcolors.utils;

/*
 *
 *
 *    █▀▀▄ █▀▀ █ █ ▀▀█▀▀ ░█▀▀█ █▀▀█ █   █▀▀█ █▀▀█ █▀▀
 *    █  █ █▀▀ ▄▀▄   █   ░█    █  █ █   █  █ █▄▄▀ ▀▀█
 *    ▀  ▀ ▀▀▀ ▀ ▀   ▀   ░█▄▄█ ▀▀▀▀ ▀▀▀ ▀▀▀▀ ▀ ▀▀ ▀▀▀
 *
 *    Project: nextColors
 *    Author: Nicole Scheitler (nextRound)
 *    Copyright - GNU GPLv3 (C) Nicole Scheitler
 *
 *
 */

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class ColorGradients {

    private final List<List<Material>> gradientList;
    private int selectedGradient;

    public ColorGradients() {
        this.gradientList = new ArrayList<>();
        this.selectedGradient = -1;
    }

    public List<List<Material>> getGradientList() {
        return gradientList;
    }

    public int getSelectedGradient() {
        return selectedGradient;
    }

    public void setSelectedGradient(int selectedGradient) {
        this.selectedGradient = selectedGradient;
    }

    public int getNumberOfGradients() {
        return gradientList.size();
    }

    public void addNewColorGradient(List<Material> blockList) {
        gradientList.add(blockList);
    }

    public void setColorGradient(List<Material> blockList, int i) {
        gradientList.set(i, blockList);
    }
}
