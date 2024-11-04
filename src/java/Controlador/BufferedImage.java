/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author chris
 */
class BufferedImage {
    private CategoryDataset crearDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Categoría 1", "Elemento A");
        dataset.addValue(15, "Categoría 1", "Elemento B");
        dataset.addValue(12, "Categoría 2", "Elemento A");
        dataset.addValue(8, "Categoría 2", "Elemento B");
        return dataset;
    }
}
