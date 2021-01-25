package jedischool.examples.template;

public class TemplateMethodExample {

  public static void main(String[] args) {
    FileReader reader = new AuthenticatedUrlFileReader();

    String content = reader.read("https://www.practo.com/path/to/the/file");

    System.out.println("File Content: " + content);
  }

  // ==============================================================
  // FileReader
  // ==============================================================

  public interface FileReader {
    public String read(String path);
  }

  public interface Connection {
    public String read();
  }

  public static abstract class AbstractFileReader implements FileReader {

    // Empty methods available for customisation

    protected void afterOpen(Connection connection) {
    }

    protected void beforeClose(Connection connection) {
    }

    protected void afterClose() {
    }

    protected abstract Connection open(String path);

    protected String read(Connection connection) {
      System.out.println("Reading File");
      return connection.read();
    }

    protected abstract void close(Connection connection);

    /**
     * This is the Template Method.
     */
    @Override
    public String read(String path) {
      Connection connection = open(path);

      afterOpen(connection);

      String contents = read(connection);

      beforeClose(connection);

      close(connection);

      afterClose();

      return contents;
    }
  }

  /**
   * LocalFileReader
   */
  public static class LocalFileReader extends AbstractFileReader {

    @Override
    protected Connection open(String path) {
      System.out.println("Connection Opened");
      return () -> String.format("File --%s-- from Local Directory", path);
    }

    @Override
    protected void close(Connection connection) {
      System.out.println("Connection Closed");
    }
  }

  /**
   * UrlFileReader
   */
  public static class UrlFileReader extends AbstractFileReader {

    @Override
    protected Connection open(String path) {
      System.out.println("Connection Opened");
      return () -> String.format("URL --%s-- using HTTP Connection", path);
    }

    @Override
    protected void close(Connection connection) {
      System.out.println("Connection Closed");
    }
  }

  /**
   * AuthenticatedFileReader
   */
  public static class AuthenticatedUrlFileReader extends AbstractFileReader {

    @Override
    protected Connection open(String path) {
      System.out.println("Connection Opened");
      return () -> String.format("URL --%s-- using Authenticated HTTP Connection", path);
    }

    @Override
    protected void afterOpen(Connection connection) {
      System.out.println("AuthenticatedFileReader: Logging In");
    }

    @Override
    protected void beforeClose(Connection connection) {
      System.out.println("AuthenticatedFileReader: Logging Out");
    }

    @Override
    protected void close(Connection connection) {
      System.out.println("Connection Closed");
    }
  }
}
