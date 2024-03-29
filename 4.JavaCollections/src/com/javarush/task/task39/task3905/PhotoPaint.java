package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (image.length <= y || image[0].length <= x) return false;
        if (image[y][x] == desiredColor) return false;

        Color spaceColor = image[y][x];
        paintFill(image, x, y, desiredColor, spaceColor);
        return true;
    }

    private void paintFill(Color[][] image, int x, int y, Color desiredColor, Color originalColor) {
        if (y < 0 || y >= image.length || x < 0 || x >= image[0].length) return;
        if (image[y][x] == originalColor) {
            image[y][x] = desiredColor;
            paintFill(image, x - 1, y, desiredColor, originalColor);
            paintFill(image, x + 1, y, desiredColor, originalColor);
            paintFill(image, x, y - 1, desiredColor, originalColor);
            paintFill(image, x, y + 1, desiredColor, originalColor);
        }
    }
}
