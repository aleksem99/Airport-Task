package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-10-04T00:07:10")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Integer> idRoute;
    public static volatile SingularAttribute<Route, String> departureCountry;
    public static volatile SingularAttribute<Route, String> departureCity;
    public static volatile SingularAttribute<Route, String> scaledCity;
    public static volatile SingularAttribute<Route, String> entryCity;
    public static volatile SingularAttribute<Route, String> scaledCountry;
    public static volatile SingularAttribute<Route, String> entryCountry;

}