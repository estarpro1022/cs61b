public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV,
                  double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet planet) {
        double x = planet.xxPos - xxPos;
        double y = planet.yyPos - yyPos;
        return Math.sqrt(x * x + y * y);
    }

    public double calcForceExertedBy(Planet planet) {
        double G = 6.67e-11;
        double distance = calcDistance(planet);
        return G * mass * planet.mass / Math.pow(distance, 2);
    }
    public double calcForceExertedByX(Planet planet) {
        double distance = calcDistance(planet);
        double force = calcForceExertedBy(planet);
        return force * (planet.xxPos - xxPos) / distance;
    }

    public double calcForceExertedByY(Planet planet) {
        double distance = calcDistance(planet);
        double force = calcForceExertedBy(planet);
        return force * (planet.yyPos - yyPos) / distance;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sumForceX = 0;
        for (Planet planet: planets) {
            if (planet.equals(this))
                continue;
            sumForceX += calcForceExertedByX(planet);
        }
        return sumForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sumForceY = 0;
        for (Planet planet: planets) {
            if (planet.equals(this))
                continue;
            sumForceY += calcForceExertedByY(planet);
        }
        return sumForceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + aX * dt;
        yyVel = yyVel + aY * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
//        double xxVelNew = xxVel + aX * dt;
//        double yyVelNew = yyVel + aY * dt;
//        xxPos = xxPos + (xxVelNew + xxVel) / 2 * dt;
//        yyPos = yyPos + (yyVelNew + yyVel) / 2 * dt;
//        xxVel = xxVelNew;
//        yyVel = yyVelNew;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
