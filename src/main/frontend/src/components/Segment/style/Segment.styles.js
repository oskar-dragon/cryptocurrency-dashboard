import styled from "styled-components";

export const Container = styled.section`
  display: flex;
  width: 98%;
  direction: ${({ direction }) => direction || "row"}
  max-width: ${({ maxWidth }) => `${maxWidth}px` || "1900px"};

  justify-content: ${({ justifyContent }) => justifyContent || "flex-start"};
  margin: 1em auto;
  gap: 1em;
`;

export const InnerContainer = styled.div`
  display: flex;
`;
