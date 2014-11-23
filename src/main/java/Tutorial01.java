import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.VCARD;

class Tutorial01 {
    // some definitions
    static String personURI    = "http://somewhere/RaphaelCazenaveLeveque";
    static String givenName    = "Raphael";
    static String familyName   = "Cazenave-Leveque";
    static String fullName     = givenName + " " + familyName;

    public static void main (String args[]) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        Resource raphaelCazenaveLeveque =
                model.createResource(personURI)
                        .addProperty(VCARD.FN, fullName)
                        .addProperty(VCARD.N,
                                model.createResource() // blank node
                                        .addProperty(VCARD.Given, givenName)
                                        .addProperty(VCARD.Family, familyName));

        // list the statements in the Model
        StmtIterator iter = model.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();  // get next statement
            Resource  subject   = stmt.getSubject();     // get the subject
            Property  predicate = stmt.getPredicate();   // get the predicate

            // get the object
            // the getObject() method returns an object typed as RDFNode,
            // which is a common superclass of both Resource and Literal
            RDFNode   object    = stmt.getObject();

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }

            System.out.println(" .");
        }
    }
}
