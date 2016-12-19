package p01_ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Locale;

class Box {
    private Double length;
    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(Double length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }
    private void setWidth(Double width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }
    private void setHeight(Double height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    public Double getSurfaceArea() {
        return (2* this.length* this.width)
                + (2* this.length* this.height)
                + (2* this.width* this.height);
    }
    public Double getLateralSurfaceArea() {
        return (2* this.length* this.height)
                + (2* this.width* this.height);
    }
    public Double getVolume() {
        return this.length* this.width* this.height;
    }
}

public class p01_ClassBox {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double length = Double.valueOf(reader.readLine());
        Double width = Double.valueOf(reader.readLine());
        Double height = Double.valueOf(reader.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f\n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f\n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f\n", box.getVolume());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
