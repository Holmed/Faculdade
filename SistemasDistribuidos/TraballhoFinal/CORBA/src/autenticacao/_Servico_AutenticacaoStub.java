package autenticacao;


/**
* autenticacao/_Servico_AutenticacaoStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ServicoAutenticacao.idl
* Sunday, November 30, 2014 6:45:56 PM BRST
*/

public class _Servico_AutenticacaoStub extends org.omg.CORBA.portable.ObjectImpl implements autenticacao.Servico_Autenticacao
{

  public String autenticar_usuario (String usuario, String senha)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("autenticar_usuario", true);
                $out.write_string (usuario);
                $out.write_string (senha);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return autenticar_usuario (usuario, senha        );
            } finally {
                _releaseReply ($in);
            }
  } // autenticar_usuario

  public String cadastrar_usuario (String usuario, String senha)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("cadastrar_usuario", true);
                $out.write_string (usuario);
                $out.write_string (senha);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return cadastrar_usuario (usuario, senha        );
            } finally {
                _releaseReply ($in);
            }
  } // cadastrar_usuario

  public boolean validar_token (String token)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("validar_token", true);
                $out.write_string (token);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return validar_token (token        );
            } finally {
                _releaseReply ($in);
            }
  } // validar_token

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:autenticacao/Servico_Autenticacao:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _Servico_AutenticacaoStub
