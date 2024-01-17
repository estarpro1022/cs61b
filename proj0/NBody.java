public class NBody {
    private static int readNumber(String file) {
        In in = new In(file);
        return in.readInt();
    }

    public static double readRadius(String file) {
        In in = new In(file);
        int number = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for (int i = 0; i < number; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please supply T, dt and filename.");
            return;
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        int number = readNumber(filename);
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);


        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        double[] forceX = new double[number];
        double[] forceY = new double[number];

        for (double t = 0; t < T; t += dt) {
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            /* each turn re-calculate force. */
            for (int i = 0; i < number; i++) {
                forceX[i] = planets[i].calcNetForceExertedByX(planets);
                forceY[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < number; i++) {
                planets[i].update(dt, forceX[i], forceY[i]);
                planets[i].draw();
            }
            StdDraw.pause(10);
            StdDraw.show();
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
