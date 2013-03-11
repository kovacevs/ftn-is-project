package ftn.is.util;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import ftn.is.model.*;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CustomTManager {

  // Injects UserTransaction 
  @Resource
  private UserTransaction utx; 
  
  @Inject
  private EntityManager em;
  
  public EntityManager getEM(){
	  return em;
  }
  
	public void removeEverything(){
	    try {
	        utx.begin();
	        em.joinTransaction();
	        
			System.out.println("Removing everything from database...");

			em.createQuery("DELETE FROM OdslusanPredmet o").executeUpdate();
			em.createQuery("DELETE FROM PrijavljenIspit o").executeUpdate();
			em.createQuery("DELETE FROM Ocena o").executeUpdate();
			em.createQuery("DELETE FROM Obaveza o").executeUpdate();
			em.createQuery("DELETE FROM Prisustvo o").executeUpdate();
			em.createQuery("DELETE FROM PripadnostGrupi o").executeUpdate();
			em.createQuery("DELETE FROM Grupa o").executeUpdate();
			em.createQuery("DELETE FROM Predmet o").executeUpdate();
			em.createQuery("DELETE FROM Student o").executeUpdate();
			em.createQuery("DELETE FROM Nastavnik o").executeUpdate();
			em.createQuery("DELETE FROM Odsek o").executeUpdate();
			em.createQuery("DELETE FROM Administrator o").executeUpdate();
			em.flush();
	        
	        utx.commit(); 

	    } catch (Exception e ) {
	        try {
				utx.setRollbackOnly();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	        e.printStackTrace();
	    }

	}
  
	
  public void save(Administrator a){
    try {
        utx.begin();
        em.joinTransaction();
        
        em.merge(a);
        em.flush();
        utx.commit(); 
       
    } catch (Exception e ) {
        try {
			utx.setRollbackOnly();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        e.printStackTrace();
    }
  }
    
    public void save(Grupa a){
        try {
            utx.begin();
            em.joinTransaction();
            em.merge(a);
            em.flush();
            utx.commit(); 
     
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Nastavnik a){
        try {
            utx.begin();
            em.joinTransaction();
            
            em.merge(a);
            em.flush();
            utx.commit(); 
    
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Obaveza a){
        try {
            utx.begin();
            em.joinTransaction();
            
            em.merge(a);
            em.flush();
            utx.commit(); 
  
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Ocena a){
        try {
            utx.begin();
            em.joinTransaction();
            
            em.merge(a);
            em.flush();
            utx.commit(); 
          
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Odsek a){
        try {
            utx.begin();
            em.joinTransaction();
            
            em.merge(a);
            em.flush();
            utx.commit(); 
          
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(OdslusanPredmet a){
        try {
            utx.begin();
            em.joinTransaction();
            
            em.merge(a);
            em.flush();
            utx.commit(); 
  
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Predmet a){
        try {
            utx.begin();
            em.joinTransaction();

            em.merge(a);
            em.flush();
            utx.commit(); 
       
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(PrijavljenIspit a){
        try {
            utx.begin();
            em.joinTransaction();

            em.merge(a);
            em.flush();
            utx.commit(); 
         
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(PripadnostGrupi a){
        try {
            utx.begin();
            em.joinTransaction();

            em.merge(a);
            em.flush();
            utx.commit(); 
          
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Prisustvo a){
        try {
            utx.begin();
            em.joinTransaction();

            em.merge(a);
            em.flush();
            utx.commit(); 
       
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
    
    public void save(Student a){
        try {
            utx.begin();
            em.joinTransaction();

            em.merge(a);
            em.flush();
            utx.commit();
         
        } catch (Exception e ) {
            try {
    			utx.setRollbackOnly();
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
            e.printStackTrace();
        }
    }
}