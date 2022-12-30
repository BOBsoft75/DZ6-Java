public class notebook {
    int id;
    int hardDisk;
    int RAM;
    String operatingSystem;
    String color;

    public notebook(int id, int hardDisk, int RAM, String operatingSystem, String color) {
        this.id = id;
        this.RAM = RAM;
        this.hardDisk = hardDisk;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", hardDisk=" + hardDisk +
                ", RAM=" + RAM +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public boolean filteringCriteria(Integer key, String filter) {
        switch (key) {
            case 1 -> { //OЗУ
                return this.RAM >= Integer.parseInt(filter);
            }
            case 2 -> { //Объем HDD
                return this.hardDisk >= Integer.parseInt(filter);
            }
            case 3 -> { //Операционная система
                return this.operatingSystem.toLowerCase().contains(filter.toLowerCase());
            }
            case 4 -> { //Цвет
                return this.color.toLowerCase().contains(filter.toLowerCase());
            }

        }
        return false;
    }
}


