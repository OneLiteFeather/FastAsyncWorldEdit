/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.bukkit.adapter;

/**
 * Reflection helper to deal with obfuscation.
 */
public class Refraction {

    private static final String MOJANG_MAPPED_CLASS_NAME = "net.minecraft.nbt.ListTag";
    private static final boolean IS_MOJANG_MAPPED;

    static {
        boolean isMojangMapped;
        try {
            Class.forName(MOJANG_MAPPED_CLASS_NAME, false, Refraction.class.getClassLoader());
            isMojangMapped = true;
        } catch (ClassNotFoundException e) {
            isMojangMapped = false;
        }
        IS_MOJANG_MAPPED = isMojangMapped;
    }

    public static String pickName(String mojangName, String spigotName) {
        return IS_MOJANG_MAPPED ? mojangName : spigotName;
    }

    public static boolean isMojangMapped() {
        return IS_MOJANG_MAPPED;
    }

    private Refraction() {
    }

}
