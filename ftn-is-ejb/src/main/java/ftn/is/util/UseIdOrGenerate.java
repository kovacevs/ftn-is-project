package ftn.is.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;


public class UseIdOrGenerate extends IdentityGenerator {
	
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        if (object == null){
            throw new HibernateException(new NullPointerException());
        }
        String idName = "";
        String className = object.getClass().getSimpleName();
        
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(GeneratedValue.class)) {
                boolean isAccessible = field.isAccessible();
                try {
                    field.setAccessible(true);
                    idName = field.getName();
                    Object obj = field.get(object);
                    field.setAccessible(isAccessible);
                    if (obj != null) {
                        if (Integer.class.isAssignableFrom(obj.getClass())) {
                            if (((Integer) obj) > 0) {
                                return (Serializable) obj;
                            }
                        }
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        
        //Kada imam iterativno dodavanje istih entitija u jednoj transakciji morace se pozivati flush, da bi
        //podaci bili persistovani u bazu i da bi sledeci select max vratio novi ID
        int nextId=0;
        if(!idName.equals(""))
        	try{
	        	String sql = "SELECT MAX(" + idName + ") FROM " + className;
	        	PreparedStatement st = session.connection().prepareStatement(sql);
	        	ResultSet rs = st.executeQuery();
	        	if(rs.next()){
					nextId = rs.getInt(1) + 1;
					if(rs.wasNull())
						nextId = 1;
				}
				else {
					nextId = 1;
				}
	        	rs.close();
	        	st.close();

        	}catch(Exception e){
        		e.printStackTrace();
        	}

        return (Integer)nextId;
    }
}