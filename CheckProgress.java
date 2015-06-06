

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author proga_000
 */
public class CheckProgress extends javax.swing.JPanel {

	static String username;
	// Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea studentProgressTextArea;
    // End of variables declaration    
	
    /**
     * Creates new form CheckProgress1
     */
    public CheckProgress(String name) {
        initComponents();
        displayData(name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentProgressTextArea = new javax.swing.JTextArea();

        studentProgressTextArea.setColumns(20);
        studentProgressTextArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        studentProgressTextArea.setRows(5);
        jScrollPane1.setViewportView(studentProgressTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void displayData(String name){
    	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
    	username = name;
    	String newline = "\n";
     	
    	Query query1 = entitymanager.createQuery("SELECT s.basicAnimalGameScore FROM student_info s WHERE s.name=:sname");
    	query1.setParameter("sname", username);
    	
    	try{
    		int result = (int) query1.getSingleResult();
    		String nameText = "Student: " + name;
    		String basicAnimal = "Basic Animals Game Score:   ";
    		studentProgressTextArea.append(nameText + newline + basicAnimal + result + newline);
    	}
    	catch(NoResultException e){
     		//student is not already in the database
     		studentProgressTextArea.append("This student is not in the database");
     	}
    	
    	Query query2 = entitymanager.createQuery("SELECT s.basicNumberGameScore FROM student_info s WHERE s.name=:sname");
    	query2.setParameter("sname", username);
    	
    	try{
    		int result = (int) query2.getSingleResult();
    		String basicNumber = "Basic Numbers Game Score:   ";
    		studentProgressTextArea.append(basicNumber + result + newline);
    	}
    	catch(NoResultException e){
    		//do nothing
    	}
    	
    	Query query3 = entitymanager.createQuery("SELECT s.basicLetterGameScore FROM student_info s WHERE s.name=:sname");
    	query3.setParameter("sname", username);
    	
    	try{
    		int result = (int) query3.getSingleResult();
    		String basicLetter = "Basic Letters Game Score:   ";
    		studentProgressTextArea.append(basicLetter + result + newline);
    	}
    	catch(NoResultException e){
    		//do nothing
    	}
    	

    	Query query4 = entitymanager.createQuery("SELECT s.advLetterGameScore FROM student_info s WHERE s.name=:sname");
    	query4.setParameter("sname", username);
    	
    	try{
    		int result = (int) query4.getSingleResult();
    		String advLetter = "Advanced Letters Game Score:   ";
    		studentProgressTextArea.append(advLetter + result + newline);
    	}
    	catch(NoResultException e){
    		//do nothing
    	}
    	
    	Query query5 = entitymanager.createQuery("SELECT s.advCountingGameScore FROM student_info s WHERE s.name=:sname");
    	query5.setParameter("sname", username);
    	
    	try{
    		int result = (int) query5.getSingleResult();
    		String advNumbers = "Advanced Numbers Game Score:   ";
    		studentProgressTextArea.append(advNumbers + result + newline);
    	}
    	catch(NoResultException e){
    		//do nothing
    	}
    
    	
    }
    
    public static void main(String args[]) {
    	CheckProgress p1 = new CheckProgress("Paige Rogalski");
    }
                   
}
