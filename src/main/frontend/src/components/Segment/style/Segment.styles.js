import styled from "styled-components";

export const Container = styled.section`
  display: flex;
  width: 98%;
  max-width: 1900px;

  justify-content: space-between;
  margin: 1em auto;
  gap: 1em;
`;

export const InnerContainer = styled.div`
  display: flex;
`;

export const Title = styled.h1`
  font-size: var(--fs-h1);
  font-weight: var(--fw-bold);
  margin-top: 0;
`;

export const Span = styled.span`
  font-weight: var(--fw-reg);
`;

export const SubTitle = styled.h2`
  font-size: var(--fs-h2);
  margin: 0;
`;
