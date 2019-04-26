import java.util.ArrayList;

class ArrayListExample {

    // Define the following methods.  No casts allowed!

    // total_area -- takes a list of 2-d shapes and calculates the total
    // area of those shapes 

    // total_perimeter -- takes a list of rectangles and calculates the
    // total perimeter

    // describe_all -- takes a list of geometric shapes and invokes the
    // 'describe' method on each of them, then prints out the total number
    // of shapes

    // add_empties  -- takes a list of geometric shapes and adds 
    // the following objects to it: 
    //  new Circle(0.0)
    //  new Cone(0.0,0.0)
    //  new Rectangle(0.0,0.0)
    //  new Sphere(0.0)


    // leave this main method as is:
    public static void main(String[] args) {

        // Make a list of shapes, add a circle, a cone, and some empty 
        // shapes.  Then describe all of the shapes
        System.out.println();
        System.out.print("Example with a list of shapes with a circle, ");
        System.out.println("a cone, and some empty shapes");
        ArrayList<GeometricShape> shapes = new ArrayList<GeometricShape>();
        shapes.add(new Circle(1.0));
        shapes.add(new Cone(2.0, 3.0));
        add_empties(shapes);
        describe_all(shapes);

        // Make a list of rectangles, and add some rectangles.  
        // Describe the rectangles, and calculate the total area 
        // and total perimeter.
        System.out.println();
        System.out.println("Example with a list of rectangles");
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
        rects.add(new Rectangle(2.0, 3.0));
        rects.add(new Rectangle(5.0, 5.0));
        describe_all(rects);
        System.out.print("total area of rectangles: ");
        System.out.println(total_area(rects));
        System.out.print("total perimeter of rectangles: ");
        System.out.println(total_perimeter(rects));

        // Make a list of 2-d shapes, and add a rectangle and a circle.
        // Describe the shapes and calculate the total area.
        System.out.println();
        System.out.print("Example with a list of 2d shapes with a circle ");
        System.out.println("and a rectangle");
        ArrayList<TwoDShape> flat_shapes = new ArrayList<TwoDShape>();
        flat_shapes.add(new Rectangle(10.0, 10.0));
        flat_shapes.add(new Circle(2.0));
        describe_all(flat_shapes);
        System.out.print("total area of flat shapes: ");
        System.out.println(total_area(flat_shapes));

        // Make a list of spheres and describe them
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        spheres.add(new Sphere(10.0));
        spheres.add(new Sphere(50.0));
        spheres.add(new Sphere(0.0));
        System.out.println();
        System.out.println("Example list of spheres");
        describe_all(spheres);

        
    }

    public static double total_area(ArrayList<? extends TwoDShape> list) {
        double area = 0.0;
        for (TwoDShape shape : list) {
            area += shape.area();
        }
        return area;
    }

    public static double total_perimeter(ArrayList<Rectangle> list) {
        double perimeter = 0.0;
        for(Rectangle rect : list) {
            perimeter += rect.perimeter();
        }
        return perimeter;
    }

    public static void describe_all(ArrayList<? extends GeometricShape> list) {
        for(GeometricShape shape : list) {
            shape.describe();
        }
    }

    public static void add_empties(ArrayList<GeometricShape> list) {
        list.add(new Circle(0.0));
        list.add(new Cone(0.0, 0.0));
        list.add(new Rectangle(0.0, 0.0));
        list.add(new Sphere(0.0));
    }

    
}
