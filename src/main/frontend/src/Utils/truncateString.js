export default function truncateString(string, n) {
  return string.length > n ? string.substring(0, n).concat("...") : string;
}
