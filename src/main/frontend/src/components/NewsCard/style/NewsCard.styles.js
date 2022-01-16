import styled from "styled-components";

export const Container = styled.div`
  background: var(--clr-light);
  width: 100%;
  max-width: 400px;
  padding: 1em;
  border-radius: 8px;
  height: 250px;
`;

// export const HeaderContainer = styled.div`
//   display: flex;
//   flex-direction: ${props => props.flexDirection};
//   justify-content: space-between;
//   align-items: center;
// `;

export const HeaderTitle = styled.h3`
  margin: 0;
  font-size: var(--fs-subtitle);
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  height: calc(100% - 20px);
  overflow-y: auto;
`;

export const NewsContainer = styled.a`
  width: 100%;
  display: grid;
  grid-template-columns: 50px 1fr;
  gap: 0 1em;
  color: var(--clr-black);
  text-decoration: none;

  justify-content: space-between;
  margin-top: 1em;
  padding-bottom: 0.7em;
  border-bottom: 1px solid lightgrey;

  ${Content} &:last-child {
    border-bottom: none;
    padding-bottom: 0;
  }
`;

export const Title = styled.h4`
  margin: 0;
`;

export const Image = styled.img`
  border-radius: 5px;
`;

export const LastUpdated = styled.p`
  margin: 0 0 0 4.6em;
  color: var(--clr-semilight);
  font-weight: var(--fw-medium);
`;
