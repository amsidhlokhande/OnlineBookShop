export const environment = {
  production: true,
  apiUrl: window["env"]["apiUrl"] || "http://localhost:8282/onlineshop/books",
  debug: window["env"]["debug"] || false
};
