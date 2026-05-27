package usuarios.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

/**
 * Servicio para integrar el Modelo de Lenguaje (LLM) a través de OpenRouter.
 */
public class LlmService {

    private String apiKey;
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";

    public LlmService() {
        this.apiKey = cargarApiKey();
    }

    /**
     * Actividad: Protege la API Key cargándola desde un archivo externo.
     */
    private String cargarApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
            return properties.getProperty("OPENROUTER_API_KEY");
        } catch (IOException e) {
            System.err.println("Error: No se pudo leer config.properties. Asegúrate de que el archivo existe.");
            return null;
        }
    }

    /**
     * Actividad: Envía peticiones HTTP a OpenRouter y devuelve la respuesta.
     * @param prompt La instrucción para la IA.
     * @return La respuesta generada por el modelo.
     */
    public String enviarPrompt(String prompt) {
        if (apiKey == null || apiKey.isEmpty()) {
            return "Error: API Key no configurada.";
        }

        try {
            // 1. Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // 2. Construir el cuerpo de la petición en formato JSON
            // Usamos un modelo gratuito como 'google/gemini-2.0-flash-lite-preview-02-05:free'
            String jsonBody = """
                {
                  "model": "google/gemini-2.0-flash-lite-preview-02-05:free",
                  "messages": [
                    {
                      "role": "user",
                      "content": "%s"
                    }
                  ]
                }
                """.formatted(prompt);

            // 3. Configurar la petición (Headers y Método POST)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // 4. Enviar y recibir respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return extraerRespuestaJson(response.body());
            } else {
                return "Error de la API (Código: " + response.statusCode() + "): " + response.body();
            }

        } catch (Exception e) {
            return "Error de conexión o gestión de datos: " + e.getMessage();
        }
    }

    /**
     * Actividad: Extraer el texto generado del JSON de respuesta.
     */
    private String extraerRespuestaJson(String jsonResponse) {
        try {
            // Buscamos la propiedad "content" dentro del JSON de OpenRouter de forma manual
            int inicio = jsonResponse.indexOf("\"content\":") + 11;
            int fin = jsonResponse.indexOf("\"", inicio);
            String resultado = jsonResponse.substring(inicio, fin);
            
            // Limpiar saltos de línea literales (\n) para que se vean bien en consola
            return resultado.replace("\\n", "\n").replace("\\\"", "\"");
        } catch (Exception e) {
            return "Error al procesar la respuesta de la IA.";
        }
    }
}