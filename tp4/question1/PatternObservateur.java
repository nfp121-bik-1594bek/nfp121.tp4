package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();           // création d'un "observé" constitué d'une liste
        observer = new ConcreteObserver();      // création d'un observateur
        list.addObserver(observer);             // ajouter cet observateur à la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) être notifi�
        assertFalse(observer.senders().empty());                         // elle ne doit pas être vide: 
        assertEquals(list, observer.senders().pop());                       // est-ce le bon émetteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le paramètre reçu est-il correct ?
    }

    // une liste, 2 observateurs
    public void test1() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        
        if (o1.senders().empty() || o2.senders().empty()){
            System.out.println("Empty Stack");
        }else{
        assertEquals(l1, o1.senders().pop()); //Verifier si l1 et le sender sont egaux
        assertEquals(l1,   o2.senders().pop());  
        }
        
        if (o1.arguments().empty() || o2.arguments().empty()){
            System.out.println("Empty Stack");
        }else{
          assertEquals(" 1 ", o1.arguments().pop());
          assertEquals(" 1 ", o2.arguments().pop());
        }
        
        

        // ne pas modifier ces lignes, dernières assertions vraies de cette
        // méthode
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    // deux listes, 1 observateur
    public void test2() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        // à compléter à partir de la ligne 56
        // vérifier que l'observateur a bien été notifié par les deux listes
        
        // à compléter !!
        
        if (o.senders().empty()){
            System.out.println("Empty Stack");
        }else{
        assertEquals("testA", o.arguments().pop()); //Verifier si l1 et le sender sont egaux
        assertEquals(" A ",   o.arguments().pop());
        assertEquals("testb", o.arguments().pop()); //Verifier si l1 et le sender sont egaux
        assertEquals(" B ",   o.arguments().pop());  
        }
        
        // ne pas modifier cette ligne, dernière assertion vraie de cette
        // méthode
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    // deux listes, 2 observateurs
    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);

        // à compléter à partir de la ligne 81
        // vérifier le bon fonctionnement de countObservers(), de deleteObserver
        // et deleteObservers()

        // à compléter !!
        if (l1.countObservers() == 0 || l2.countObservers() == 0){
            System.out.println("One of them got no observers");
        }else{
            assertEquals(2, l1.countObservers());
            assertEquals(2,l2.countObservers());
            l1.deleteObserver(o1);
            assertEquals(1, l1.countObservers());
            l2.deleteObserver(o1);
            assertEquals(1, l2.countObservers());
        }
        
        
        

        // ne pas modifier ces lignes, dernières assertions vraies de cette
        // méthode
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
}
