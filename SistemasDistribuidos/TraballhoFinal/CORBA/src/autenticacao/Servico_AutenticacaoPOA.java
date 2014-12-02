package autenticacao;


/**
* autenticacao/Servico_AutenticacaoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServicoAutenticacao.idl
* Monday, December 1, 2014 11:50:11 PM BRST
*/

public abstract class Servico_AutenticacaoPOA extends org.omg.PortableServer.Servant
 implements autenticacao.Servico_AutenticacaoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("autenticar_usuario", new java.lang.Integer (0));
    _methods.put ("cadastrar_usuario", new java.lang.Integer (1));
    _methods.put ("validar_token", new java.lang.Integer (2));
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
       case 0:  // autenticacao/Servico_Autenticacao/autenticar_usuario
       {
         String usuario = in.read_string ();
         String senha = in.read_string ();
         String $result = null;
         $result = this.autenticar_usuario (usuario, senha);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // autenticacao/Servico_Autenticacao/cadastrar_usuario
       {
         String usuario = in.read_string ();
         String senha = in.read_string ();
         String $result = null;
         $result = this.cadastrar_usuario (usuario, senha);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // autenticacao/Servico_Autenticacao/validar_token
       {
         String token = in.read_string ();
         boolean $result = false;
         $result = this.validar_token (token);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:autenticacao/Servico_Autenticacao:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Servico_Autenticacao _this() 
  {
    return Servico_AutenticacaoHelper.narrow(
    super._this_object());
  }

  public Servico_Autenticacao _this(org.omg.CORBA.ORB orb) 
  {
    return Servico_AutenticacaoHelper.narrow(
    super._this_object(orb));
  }


} // class Servico_AutenticacaoPOA
