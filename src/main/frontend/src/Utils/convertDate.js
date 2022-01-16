function addLeadingZero(data) {
  return data < 9 ? `0${data}` : data;
}

export default function convertDate(data) {
  const date = new Date(data);
  const month = addLeadingZero(date.getUTCMonth() + 1).toString();
  const day = addLeadingZero(date.getDate()).toString();
  const year = date.getFullYear().toString();

  return `${month}/${day}/${year}`;
}
