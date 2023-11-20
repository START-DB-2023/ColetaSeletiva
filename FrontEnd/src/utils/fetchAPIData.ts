import axios from "axios";

const fetchAPIData = axios.create({
  baseURL: "http://localhost:8080/api/",
});

export default fetchAPIData;
