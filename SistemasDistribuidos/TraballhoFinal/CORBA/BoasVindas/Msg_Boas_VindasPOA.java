package BoasVindas;


/**
* BoasVindas/Msg_Boas_VindasPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from BoasVindas.idl
* Sunday, November 30, 2014 1:50:46 PM BRST
*/

public abstract class Msg_Boas_VindasPOA extends org.omg.PortableServer.Servant
 implements BoasVindas.Msg_Boas_VindasOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("boas_vindas", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // BoasVindas/Msg_Boas_Vindas/boas_vindas
       {
         String $result = null;
         $result = this.boas_vindas ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:BoasVindas/Msg_Boas_Vindas:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Msg_Boas_Vindas _this() 
  {
    return Msg_Boas_VindasHelper.narrow(
    super._this_object());
  }

  public Msg_Boas_Vindas _this(org.omg.CORBA.ORB orb) 
  {
    return Msg_Boas_VindasHelper.narrow(
    super._this_object(orb));
  }


} // class Msg_Boas_VindasPOA
