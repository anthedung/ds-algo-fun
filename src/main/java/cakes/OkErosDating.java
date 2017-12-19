package cakes;

import java.util.Arrays;

/**
 * find intersection of 2 rectangles
 */


public class OkErosDating {
    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static Rectangle findIntersection(Rectangle a, Rectangle b) {
        int[] xPoints = new int[]{a.leftX, a.leftX + a.width, b.leftX, b.leftX + b.width};
        int[] yPoints = new int[]{a.bottomY, a.bottomY + a.height, b.bottomY, b.bottomY + b.height};

        if (isOverlap(a.leftX, a.leftX + a.width, b.leftX, b.leftX + b.width)
                && isOverlap(a.bottomY, a.bottomY + a.height, b.bottomY, b.bottomY + b.height)) {
            Arrays.sort(xPoints);
            Arrays.sort(yPoints);

            return new Rectangle(xPoints[1], yPoints[1], xPoints[2] - xPoints[1], yPoints[2] - yPoints[1]);
        }


        return null;
    }

    private static boolean isOverlap(int aX1, int aX2, int bX1, int bX2) {
        return (aX2 > bX1 && aX1 < bX2) || (bX2 < aX1 && bX1 < aX2);
    }
}
