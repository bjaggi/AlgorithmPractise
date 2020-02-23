package amazin;

import java.util.Map;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

//https://www.hackerrank.com/contests/expansion-challenge/challenges/decoding-json/problem

    public class DecodeJson {
        public static void main(String[] args) {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            DecodingJSON solver = new DecodingJSON();
            solver.solve(1, in, out);
            out.close();
        }
    }

    class DecodingJSON {
        private char pc;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int q = in.nextInt();
            readObjectStart(in);
            JSONObject j = parse(in);
            in.readLine();
            //System.out.println(Arrays.toString("address.city".split("[.]")));
            for (int i = 0;i < q;i++) {
                in.readLine();
                String query = in.next();
                String v[] = query.split("[.]");
                JSONObject t = j;
                for (int k = 0;k < v.length;k++) {
                    t = t.mp.get(v[k]);
                    if(t == null) break;
                }
                if(t == null) out.println(t);
                else if(t.s != null) out.println("\"" + t.s + "\"");
                else if(t.n != Integer.MAX_VALUE) out.println(t.n);
                else if(t.b != 0) out.println(t.b == 1 ? true : false);
                else out.println("null");
            }
        }
        public JSONObject parse(InputReader in) {
            JSONObject j = new JSONObject();
            while (true) {
                String key = nextKey(in);
                if(key == null) return j;
                char ch = nextNonSpaceChar(in);
                boolean isNumber = false;
                if(ch == '{') {
                    JSONObject js = parse(in);
                    j.mp.put(key, js);
                } else if(ch == '"') {
                    String ns = nextString(in);
                    JSONObject js = new JSONObject();
                    js.s = ns;
                    j.mp.put(key, js);
                } else {
                    if((ch >= '0' && ch <= '9') || ch == '-') {
                        isNumber = true;
                        int a = nextNumber(in, ch);
                        JSONObject js = new JSONObject();
                        js.n = a;
                        j.mp.put(key, js);
                    } else if(ch == 't') {
                        JSONObject js = new JSONObject();
                        js.b = 1;
                        j.mp.put(key, js);
                        skip(in, 3);
                    } else if(ch == 'f') {
                        JSONObject js = new JSONObject();
                        js.b = 2;
                        j.mp.put(key, js);
                        skip(in, 4);
                    } else {
                        skip(in, 3);
                    }
                }
                if(isNumber ) {
                    if(pc == '}') break;
                }
                else if(!isNext(in)) {
                    break;
                }
            }
            return j;
        }

        public int nextNumber(InputReader in, char nn) {

            int n = nn == '-' ? 0 : (nn - '0');
            while (true) {
                char ch = in.readNextChar();
                if(ch >= '0' && ch <= '9') {
                    n = n*10 + (ch - '0');
                } else {
                    pc = ch;
                    return nn == '-' ? -n : n;
                }
            }
        }

        public char nextNonSpaceChar(InputReader in) {
            while (true) {
                char ch = in.readNextChar();
                String s = "" + ch;
                if (s.matches("[0-9\"ftn{-]")) {
                    return ch;
                }
            }
        }

        public boolean isNext(InputReader in) {
            while (true) {
                char ch = in.readNextChar();
                String s = "" + ch;
                if (s.matches("[,}]")) {
                    return ch == ',';
                }
            }
        }



        public void readObjectStart(InputReader in) {
            while (in.readNextChar() != '{');
        }

        public String nextKey(InputReader in) {
            while (true) {
                char ch = in.readNextChar();
                if(ch == '}') return null;//end of object no more keys
                if(ch == '"') break;
            }
            StringBuilder sb = new StringBuilder();
            char ch = in.readNextChar();
            while (ch != '"') {
                if(ch == '\\') {
                    ch = in.readNextChar();
                }
                sb.append(ch);
                ch = in.readNextChar();
            }
            while (in.readNextChar() != ':');
            return sb.toString();
        }

        public void skip(InputReader in, int n) {
            for (int i = 0;i < n;i++) in.readNextChar();
        }

        public String nextString(InputReader in) {
            StringBuilder sb = new StringBuilder();
            char ch = in.readNextChar();
            while (ch != '"') {
                if(ch == '\\') {
                    ch = in.readNextChar();
                }
                sb.append(ch);
                ch = in.readNextChar();
            }
            return sb.toString();
        }



        class JSONObject {
            Map<String, JSONObject> mp = new HashMap<String, JSONObject>();
            String s;
            int n = Integer.MAX_VALUE;
            int b = 0;

            public String toString() {
                return s != null ? s : "{" + mp.toString() + "}";
            }
        }


    }

    class InputReader {
        private BufferedReader br;
        private StringTokenizer st;
        public InputReader(InputStream in) {
            br=new BufferedReader(new InputStreamReader(in));
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException ignored) {

            }
        }

        public boolean readLine() {
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException e) {
                return false;
            }
            return true;
        }
        public int nextInt(){
            return Integer.parseInt(st.nextToken());
        }

        public String next(){
            return st.nextToken();
        }

        public char readNextChar() {
            try {
                return (char)(br.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return (char)(0);
        }

    }

